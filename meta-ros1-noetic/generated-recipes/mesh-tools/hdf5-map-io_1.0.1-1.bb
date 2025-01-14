# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_noetic
inherit ros_superflore_generated

DESCRIPTION = "The hdf5_map_io package"
AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
ROS_AUTHOR = "Sebastian Pütz <spuetz@uos.de>"
HOMEPAGE = "http://wiki.ros.org/ros_mesh_tools/hdf5_map_io"
SECTION = "devel"
# Original license in package.xml, joined with "&" when multiple license tags were used:
#         "BSD-3"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=76ea7cd512d17201ff67e2488e8c4ce3"

ROS_CN = "mesh_tools"
ROS_BPN = "hdf5_map_io"

ROS_BUILD_DEPENDS = " \
    boost \
    lvr2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    lvr2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    lvr2 \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/uos-gbp/mesh-tools/archive/release/noetic/hdf5_map_io/1.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/noetic/hdf5_map_io"
SRC_URI = "git://github.com/uos-gbp/mesh-tools;${ROS_BRANCH};protocol=https"
SRCREV = "da9b20bb7c42472a1904733d0ab2ec03bd718670"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
