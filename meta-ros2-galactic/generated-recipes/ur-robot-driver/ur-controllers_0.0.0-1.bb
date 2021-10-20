# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "Provides controllers that use the speed scaling interface of Universal Robots."
AUTHOR = "Marvin Große Besselmann <grosse@fzi.de>"
ROS_AUTHOR = "Marvin Große Besselmann"
HOMEPAGE = "https://github.com/UniversalRobots/Universal_Robots_ROS2_Driver/issues"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "ur_robot_driver"
ROS_BPN = "ur_controllers"

ROS_BUILD_DEPENDS = " \
    control-msgs \
    controller-interface \
    geometry-msgs \
    joint-trajectory-controller \
    pluginlib \
    rclcpp-lifecycle \
    rcutils \
    realtime-tools \
    sensor-msgs \
    std-msgs \
    std-srvs \
    ur-client-library \
    ur-dashboard-msgs \
    ur-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    control-msgs \
    controller-interface \
    geometry-msgs \
    joint-trajectory-controller \
    pluginlib \
    rclcpp-lifecycle \
    rcutils \
    realtime-tools \
    sensor-msgs \
    std-msgs \
    std-srvs \
    ur-client-library \
    ur-dashboard-msgs \
    ur-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    control-msgs \
    controller-interface \
    geometry-msgs \
    joint-trajectory-controller \
    pluginlib \
    rclcpp-lifecycle \
    rcutils \
    realtime-tools \
    sensor-msgs \
    std-msgs \
    std-srvs \
    ur-client-library \
    ur-dashboard-msgs \
    ur-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/razr/Universal_Robots_ROS2_Driver-release/archive/release/galactic/ur_controllers/0.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/ur_controllers"
SRC_URI = "git://github.com/razr/Universal_Robots_ROS2_Driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "53f186380e8ee4c2332a261246a82553feb7e091"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
