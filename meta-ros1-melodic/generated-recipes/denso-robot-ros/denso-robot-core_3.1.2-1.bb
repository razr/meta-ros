# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The denso robot core package includes a node for controlling DENSO robot controllers."
AUTHOR = "DENSO WAVE INCORPORATED <fa-support@denso-wave.com>"
ROS_AUTHOR = "DENSO WAVE INCORPORATED <fa-support@denso-wave.com>"
HOMEPAGE = "http://ros.org/wiki/denso_robot_core"
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=58e54c03ca7f821dd3967e2a2cd1596e"

ROS_CN = "denso_robot_ros"
ROS_BPN = "denso_robot_core"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    bcap-core \
    bcap-service \
    message-generation \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    bcap-core \
    bcap-service \
    message-runtime \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    bcap-core \
    bcap-service \
    message-runtime \
    roscpp \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DENSORobot/denso_robot_ros-release/archive/release/melodic/denso_robot_core/3.1.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/denso_robot_core"
SRC_URI = "git://github.com/DENSORobot/denso_robot_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "c4e96ce62d3fefec25b9d4b8b3b76b3043b184f2"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}