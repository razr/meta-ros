# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "3D visualization tool for ROS."
AUTHOR = "William Woodall <william@osrfoundation.org>"
ROS_AUTHOR = "Dave Hershberger"
HOMEPAGE = "http://wiki.ros.org/rviz"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD & Creative Commons"
LICENSE = "BSD & Creative-Commons"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rviz"
ROS_BPN = "rviz"

ROS_BUILD_DEPENDS = " \
    assimp \
    cmake-modules \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    libeigen \
    libtinyxml2 \
    map-msgs \
    mesa \
    message-filters \
    message-generation \
    nav-msgs \
    ogre \
    pluginlib \
    python-qt-binding \
    qtbase \
    resource-retriever \
    rosbag \
    rosconsole \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    urdf \
    urdfdom \
    urdfdom-headers \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    assimp \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    libtinyxml2 \
    map-msgs \
    mesa \
    message-filters \
    nav-msgs \
    ogre \
    pluginlib \
    python-qt-binding \
    resource-retriever \
    rosbag \
    rosconsole \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    urdf \
    visualization-msgs \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    assimp \
    geometry-msgs \
    image-transport \
    interactive-markers \
    laser-geometry \
    libtinyxml2 \
    map-msgs \
    media-export \
    mesa \
    message-filters \
    message-runtime \
    nav-msgs \
    ogre \
    pluginlib \
    python-qt-binding \
    qtbase \
    resource-retriever \
    rosbag \
    rosconsole \
    roscpp \
    roslib \
    rospy \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf \
    urdf \
    visualization-msgs \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rostest \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/rviz-release/archive/release/melodic/rviz/1.13.19-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rviz"
SRC_URI = "git://github.com/ros-gbp/rviz-release;${ROS_BRANCH};protocol=https"
SRCREV = "bddb6194384ce8ed6311cb6dd645ebefe8fbd2fe"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
