package org.ros;

import org.ros.namespace.GraphName;

/**
 * ROS topics. System level topics related to time keeping and logging.
 * 
 * @author Jonathan Groff Copyright (C) NeoCoreTechs 2015,2021
 */
public interface Topics {

  public static final GraphName ROSOUT = GraphName.of("/rosout");
  public static final GraphName CLOCK = GraphName.of("/clock");
}
