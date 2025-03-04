# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "Code shared on static and dynamic type support of rmw_gurumdds_cpp."
AUTHOR = "Youngjin Yun <youngjin@gurum.cc>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "Apache License 2.0"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmw_gurumdds"
ROS_BPN = "rmw_gurumdds_shared_cpp"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-gurumdds-2.7} \
    gurumdds-cmake-module \
    rcutils \
    rmw \
    rmw-dds-common \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_DEP-gurumdds-2.7} \
    gurumdds-cmake-module \
    rmw-dds-common \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    rmw-dds-common \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmw_gurumdds-release/archive/release/galactic/rmw_gurumdds_shared_cpp/2.1.9-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/rmw_gurumdds_shared_cpp"
SRC_URI = "git://github.com/ros2-gbp/rmw_gurumdds-release;${ROS_BRANCH};protocol=https"
SRCREV = "3adaca1b9b1fd909d10fd4184704d436baae5b6f"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
