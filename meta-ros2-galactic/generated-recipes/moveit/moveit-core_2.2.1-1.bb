# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_galactic
inherit ros_superflore_generated

DESCRIPTION = "Core libraries used by MoveIt"
AUTHOR = "Dave Coleman <dave@picknik.ai>"
ROS_AUTHOR = "Ioan Sucan <isucan@google.com>"
HOMEPAGE = "http://moveit.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=15;endline=15;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "moveit"
ROS_BPN = "moveit_core"

ROS_BUILD_DEPENDS = " \
    angles \
    assimp \
    boost \
    bullet \
    common-interfaces \
    eigen-stl-containers \
    fcl \
    geometric-shapes \
    geometry-msgs \
    kdl-parser \
    libeigen \
    moveit-common \
    moveit-msgs \
    octomap \
    octomap-msgs \
    pluginlib \
    pybind11-vendor \
    random-numbers \
    rclcpp \
    sensor-msgs \
    shape-msgs \
    srdfdom \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    trajectory-msgs \
    urdf \
    urdfdom \
    urdfdom-headers \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    eigen3-cmake-module-native \
    pkgconfig-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    assimp \
    boost \
    bullet \
    common-interfaces \
    eigen-stl-containers \
    fcl \
    geometric-shapes \
    geometry-msgs \
    kdl-parser \
    libeigen \
    moveit-msgs \
    octomap \
    octomap-msgs \
    pluginlib \
    pybind11-vendor \
    random-numbers \
    rclcpp \
    sensor-msgs \
    shape-msgs \
    srdfdom \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    trajectory-msgs \
    urdf \
    urdfdom \
    urdfdom-headers \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    eigen3-cmake-module-native \
"

ROS_EXEC_DEPENDS = " \
    angles \
    assimp \
    boost \
    bullet \
    common-interfaces \
    eigen-stl-containers \
    fcl \
    geometric-shapes \
    geometry-msgs \
    kdl-parser \
    libeigen \
    moveit-msgs \
    octomap \
    octomap-msgs \
    pluginlib \
    pybind11-vendor \
    random-numbers \
    rclcpp \
    sensor-msgs \
    shape-msgs \
    srdfdom \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-geometry-msgs \
    trajectory-msgs \
    urdf \
    urdfdom \
    urdfdom-headers \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gtest \
    ament-index-cpp \
    ament-lint-auto \
    ament-lint-common \
    angles \
    moveit-resources-panda-moveit-config \
    moveit-resources-pr2-description \
    orocos-kdl \
    tf2-kdl \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/moveit/moveit2-release/archive/release/galactic/moveit_core/2.2.1-1.tar.gz
ROS_BRANCH ?= "branch=release/galactic/moveit_core"
SRC_URI = "git://github.com/moveit/moveit2-release;${ROS_BRANCH};protocol=https"
SRCREV = "3d5b1cc90cdec268aac7b3441c4dcd22247aa313"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
