# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "RTAB-Map's ros-pkg. RTAB-Map is a RGB-D SLAM approach with real-time constraints."
AUTHOR = "Mathieu Labbe <matlabbe@gmail.com>"
ROS_AUTHOR = "Mathieu Labbe"
HOMEPAGE = "https://github.com/introlab/rtabmap_ros/issues"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "rtabmap_ros"
ROS_BPN = "rtabmap_ros"

ROS_BUILD_DEPENDS = " \
    class-loader \
    costmap-2d \
    cv-bridge \
    dynamic-reconfigure \
    eigen-conversions \
    find-object-2d \
    geometry-msgs \
    image-geometry \
    image-transport \
    laser-geometry \
    message-filters \
    message-generation \
    move-base-msgs \
    nav-msgs \
    nodelet \
    octomap-msgs \
    pcl \
    pcl-conversions \
    pcl-ros \
    pluginlib \
    roscpp \
    rosgraph-msgs \
    rospy \
    rtabmap \
    rviz \
    sensor-msgs \
    std-msgs \
    std-srvs \
    stereo-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
    genmsg-native \
"

ROS_EXPORT_DEPENDS = " \
    class-loader \
    compressed-depth-image-transport \
    compressed-image-transport \
    costmap-2d \
    cv-bridge \
    dynamic-reconfigure \
    eigen-conversions \
    find-object-2d \
    geometry-msgs \
    image-geometry \
    image-transport \
    laser-geometry \
    message-filters \
    message-runtime \
    move-base-msgs \
    nav-msgs \
    nodelet \
    octomap-msgs \
    pcl-conversions \
    pcl-ros \
    pluginlib \
    roscpp \
    rosgraph-msgs \
    rospy \
    rtabmap \
    rviz \
    sensor-msgs \
    std-msgs \
    std-srvs \
    stereo-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    class-loader \
    compressed-depth-image-transport \
    compressed-image-transport \
    costmap-2d \
    cv-bridge \
    dynamic-reconfigure \
    eigen-conversions \
    find-object-2d \
    geometry-msgs \
    image-geometry \
    image-transport \
    laser-geometry \
    message-filters \
    message-runtime \
    move-base-msgs \
    nav-msgs \
    nodelet \
    octomap-msgs \
    pcl-conversions \
    pcl-ros \
    pluginlib \
    roscpp \
    rosgraph-msgs \
    rospy \
    rtabmap \
    rviz \
    sensor-msgs \
    std-msgs \
    std-srvs \
    stereo-msgs \
    tf \
    tf-conversions \
    tf2-ros \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/introlab/rtabmap_ros-release/archive/release/melodic/rtabmap_ros/0.20.9-2.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rtabmap_ros"
SRC_URI = "git://github.com/introlab/rtabmap_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "ec2334442ab534e7e31464bad272cb9416121084"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
