package org.ros.internal.message;

import org.apache.commons.io.FileUtils;
import org.ros.EnvironmentVariables;
import org.ros.exception.RosRuntimeException;
import org.ros.internal.message.definition.MessageDefinitionProviderChain;
import org.ros.internal.message.definition.MessageDefinitionTupleParser;
import org.ros.internal.message.service.ServiceDefinitionFileProvider;
import org.ros.internal.message.topic.TopicDefinitionFileProvider;
import org.ros.message.MessageDeclaration;
import org.ros.message.MessageFactory;
import org.ros.message.MessageIdentifier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author jg
 */
public class GenerateClasses {

  private final TopicDefinitionFileProvider topicDefinitionFileProvider;
  private final ServiceDefinitionFileProvider serviceDefinitionFileProvider;
  private final MessageDefinitionProviderChain messageDefinitionProviderChain;
  private final MessageFactory messageFactory;

  public GenerateClasses() {
    messageDefinitionProviderChain = new MessageDefinitionProviderChain();
    topicDefinitionFileProvider = new TopicDefinitionFileProvider();
    messageDefinitionProviderChain.addMessageDefinitionProvider(topicDefinitionFileProvider);
    serviceDefinitionFileProvider = new ServiceDefinitionFileProvider();
    messageDefinitionProviderChain.addMessageDefinitionProvider(serviceDefinitionFileProvider);
    messageFactory = new DefaultMessageFactory(messageDefinitionProviderChain);
  }

  /**
   * @param packages
   *          a list of packages containing the topic types to generate
   *          interfaces for
   * @param outputDirectory
   *          the directory to write the generated interfaces to
   * @throws IOException
   */
  private void writeTopicInterfaces(File outputDirectory, Collection<String> packages)
      throws IOException {
    Collection<MessageIdentifier> topicTypes = new HashSet<MessageIdentifier>();
    if (packages.size() == 0) {
      packages = topicDefinitionFileProvider.getPackages();
    }
    for (String pkg : packages) {
      Collection<MessageIdentifier> messageIdentifiers =
          topicDefinitionFileProvider.getMessageIdentifiersByPackage(pkg);
      if (messageIdentifiers != null) {
        topicTypes.addAll(messageIdentifiers);
      }
    }
    for (MessageIdentifier topicType : topicTypes) {
      String definition = messageDefinitionProviderChain.get(topicType.getType());
      MessageDeclaration messageDeclaration = new MessageDeclaration(topicType, definition);
      writeInterface(messageDeclaration, outputDirectory, true);
    }
  }

  /**
   * @param packages
   *          a list of packages containing the topic types to generate
   *          interfaces for
   * @param outputDirectory
   *          the directory to write the generated interfaces to
   * @throws IOException
   */
  private void writeServiceInterfaces(File outputDirectory, Collection<String> packages)
      throws IOException {
    Collection<MessageIdentifier> serviceTypes = new HashSet<MessageIdentifier>();
    if (packages.size() == 0) {
      packages = serviceDefinitionFileProvider.getPackages();
    }
    for (String pkg : packages) {
      Collection<MessageIdentifier> messageIdentifiers =
          serviceDefinitionFileProvider.getMessageIdentifiersByPackage(pkg);
      if (messageIdentifiers != null) {
        serviceTypes.addAll(messageIdentifiers);
      }
    }
    for (MessageIdentifier serviceType : serviceTypes) {
      String definition = messageDefinitionProviderChain.get(serviceType.getType());
      MessageDeclaration serviceDeclaration =
          MessageDeclaration.of(serviceType.getType(), definition);
      writeInterface(serviceDeclaration, outputDirectory, false);
      List<String> requestAndResponse = MessageDefinitionTupleParser.parse(definition, 2);
      MessageDeclaration requestDeclaration =
          MessageDeclaration.of(serviceType.getType() + "Request", requestAndResponse.get(0));
      MessageDeclaration responseDeclaration =
          MessageDeclaration.of(serviceType.getType() + "Response", requestAndResponse.get(1));
      writeInterface(requestDeclaration, outputDirectory, true);
      writeInterface(responseDeclaration, outputDirectory, true);
    }
  }

  private void writeInterface(MessageDeclaration messageDeclaration, File outputDirectory,
      boolean addConstantsAndMethods) {
    MessageInterfaceBuilder builder = new MessageInterfaceBuilder();
    builder.setPackageName(messageDeclaration.getPackage());
    builder.setInterfaceName(messageDeclaration.getName());
    builder.setMessageDeclaration(messageDeclaration);
    builder.setAddConstantsAndMethods(addConstantsAndMethods);
    try {
      String content;
      content = builder.build(messageFactory);
      File file = new File(outputDirectory, messageDeclaration.getType() + ".java");
      FileUtils.writeStringToFile(file, content);
    } catch (Exception e) {
      System.out.printf("Failed to generate interface for %s.\n", messageDeclaration.getType());
      e.printStackTrace();
    }
  }

  public void generate(File outputDirectory, Collection<String> packages,
      Collection<File> packagePath) {
    for (File directory : packagePath) {
      topicDefinitionFileProvider.addDirectory(directory);
      serviceDefinitionFileProvider.addDirectory(directory);
    }
    topicDefinitionFileProvider.update();
    serviceDefinitionFileProvider.update();
    try {
      writeTopicInterfaces(outputDirectory, packages);
      writeServiceInterfaces(outputDirectory, packages);
    } catch (IOException e) {
      throw new RosRuntimeException(e);
    }
  }

  public static void main(String[] args) {
	
    List<String> arguments = new ArrayList<String>();
    for(int i =0; i < args.length; i++)arguments.add(args[i]);
    if (arguments.size() == 0) {
      arguments.add(".");
    }
    String rosPackagePath = System.getenv(EnvironmentVariables.ROS_PACKAGE_PATH);
    System.out.println("ROS Package path="+rosPackagePath);
    Collection<File> packagePath = new ArrayList<File>();
    for (String path : rosPackagePath.split(File.pathSeparator)) {
      File packageDirectory = new File(path);
      if (packageDirectory.exists()) {
        packagePath.add(packageDirectory);
      }
    }
    GenerateClasses generateInterfaces = new GenerateClasses();
    File outputDirectory = new File(arguments.remove(0));
    generateInterfaces.generate(outputDirectory, arguments, packagePath);
  }
}
