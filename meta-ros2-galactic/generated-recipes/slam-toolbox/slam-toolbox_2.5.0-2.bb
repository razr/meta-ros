# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "This package provides a sped up improved slam karto with updated SDK and visualization and modification toolsets"
AUTHOR = "Steve Macenski <stevenmacenski@gmail.com>"
ROS_AUTHOR = "Steve Macenski"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=46ee8693f40a89a31023e97ae17ecf19"

ROS_CN = "slam_toolbox"
ROS_BPN = "slam_toolbox"

ROS_BUILD_DEPENDS = " \
    boost \
    builtin-interfaces \
    ceres-solver \
    interactive-markers \
    lapack \
    libeigen \
    message-filters \
    nav-msgs \
    nav2-map-server \
    pluginlib \
    qtbase \
    rclcpp \
    rosidl-default-generators \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    sensor-msgs \
    std-msgs \
    std-srvs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tbb \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    builtin-interfaces \
    ceres-solver \
    interactive-markers \
    lapack \
    libeigen \
    message-filters \
    nav-msgs \
    nav2-map-server \
    pluginlib \
    qtbase \
    rclcpp \
    rosidl-default-generators \
    rviz-common \
    rviz-default-plugins \
    rviz-ogre-vendor \
    rviz-rendering \
    sensor-msgs \
    std-msgs \
    std-srvs \
    suitesparse-cholmod \
    suitesparse-cxsparse \
    tbb \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
    tf2-sensor-msgs \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-cpplint \
    ament-cmake-flake8 \
    ament-cmake-gtest \
    ament-cmake-uncrustify \
    ament-lint-auto \
    launch \
    launch-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/SteveMacenski/slam_toolbox-release/archive/release/galactic/slam_toolbox/2.5.0-2.tar.gz
ROS_BRANCH ?= "branch=release/galactic/slam_toolbox"
SRC_URI = "git://github.com/SteveMacenski/slam_toolbox-release;${ROS_BRANCH};protocol=https"
SRCREV = "c6c54ab19721629814621714d7d8ea5ac11b7d27"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
