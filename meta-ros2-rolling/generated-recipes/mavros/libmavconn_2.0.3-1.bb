# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_rolling
inherit ros_superflore_generated

DESCRIPTION = "MAVLink communication library.     This library provide unified connection handling classes     and URL to connection object mapper.      This library can be used in standalone programs."
AUTHOR = "Vladimir Ermakov <vooon341@gmail.com>"
ROS_AUTHOR = "Vladimir Ermakov <vooon341@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/mavros"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "GPLv3 & LGPLv3 & BSD"
LICENSE = "GPL-3.0-only & LGPL-3.0-only & BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=1e7b3bcc2e271699c77c769685058cbe"

ROS_CN = "mavros"
ROS_BPN = "libmavconn"

ROS_BUILD_DEPENDS = " \
    asio \
    console-bridge \
    mavlink \
    python3-empy \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    asio \
    console-bridge \
    mavlink \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    asio \
    console-bridge \
    mavlink \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/mavlink/mavros-release/archive/release/rolling/libmavconn/2.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/rolling/libmavconn"
SRC_URI = "git://github.com/mavlink/mavros-release;${ROS_BRANCH};protocol=https"
SRCREV = "d5f8a6d63f93080ac9dde6d1cafdf261bdf2d1a7"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
