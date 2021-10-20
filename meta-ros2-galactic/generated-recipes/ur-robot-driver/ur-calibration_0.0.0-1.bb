# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "Package for extracting the factory calibration from a UR robot and change it such that it can be used by ur_description to gain a correct URDF"
AUTHOR = "Felix Exner <exner@fzi.de>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=82f0323c08605e5b6f343b05213cf7cc"

ROS_CN = "ur_robot_driver"
ROS_BPN = "ur_calibration"

ROS_BUILD_DEPENDS = " \
    libeigen \
    rclcpp \
    tf2-ros \
    ur-client-library \
    ur-robot-driver \
    yaml-cpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
    rclcpp \
    ur-client-library \
    ur-robot-driver \
    yaml-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    libeigen \
    rclcpp \
    ur-client-library \
    ur-robot-driver \
    yaml-cpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/razr/Universal_Robots_ROS2_Driver-release/archive/release/galactic/ur_calibration/0.0.0-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/ur_calibration"
SRC_URI = "git://github.com/razr/Universal_Robots_ROS2_Driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "e169aa67b6fa8308e6fb862a79c75df681227cf5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
