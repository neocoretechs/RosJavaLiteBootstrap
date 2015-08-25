ROSBase
=======

Provides org.ros.internal.message.GenerateClasses to create Java bindings from ROS message files as well as org.ros message implementations critical to ROS core operation

Set ROS_PACKAGE_PATH shell variable to [path_to_message_files]

java -cp <all_the_jars> org.ros.internal.message.GenerateInterfaces [output_dir]

To generate the Java bindings for the message files. 
build.xml ant task will JAR up the files to RosBase.jar

Note that in RosjavaLite the serialization mechanism is Java based so instead of interfaces we generate concrete serializable classes.
