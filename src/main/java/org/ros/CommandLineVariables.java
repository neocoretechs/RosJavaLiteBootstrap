package org.ros;

/**
 * Remapping keys used to override ROS environment and other configuration
 * settings from a command-line-based executation of a node. As of ROS 1.4, only
 * {@code CommandLine.NODE_NAME} and {@code CommandLine.ROS_NAMESPACE} are
 * required.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public interface CommandLineVariables {

  public static String ROS_NAMESPACE = "__ns";
  public static String ROS_IP = "__ip";
  public static String ROS_MASTER_URI = "__master";
  public static String NODE_NAME = "__name";
  public static String NODE_VISIBILITY = "__visibility";
  
}
