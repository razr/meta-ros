# foxy/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2020-2021 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Foxy Fitzroy"

ROS2_DISTRO = "foxy"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-focal"

require conf/ros-distro/include/foxy/generated/superflore-datetime.inc
require conf/ros-distro/include/foxy/generated/superflore-ros-distro.inc
require conf/ros-distro/include/foxy/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-versions.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    domain-coordinator-native \
    foonathan-memory-vendor-native \
    rcpputils-native \
    rmw-dds-common-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-native \
    rosidl-adapter-native \
    rosidl-default-runtime-native \
    rosidl-parser-native \
    rosidl-typesupport-fastrtps-c-native \
    rpyutils-native \
    uncrustify-vendor-native \
"

# this needs google-benchmark-vendor-native but we probably don't need native version
ROS_SUPERFLORE_GENERATED_BUILDTOOLS:remove = "ament-cmake-google-benchmark-native"

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "opensplice"
# alternative not yet supported implementation for fastrtps, there is no recipe for gurumdds-2.6
ROS_WORLD_SKIP_GROUPS += "gurumdds"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"
# recipes depending on openni (libopenni-dev)
ROS_WORLD_SKIP_GROUPS += "openni"
# recipes depending on turtlebot3 specific recipes which weren't ported to eloquent yet
ROS_WORLD_SKIP_GROUPS += "turtlebot3"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# recipes depending on ROS_UNRESOLVED_DEP-python3-babeltrace which cannot be just
# set to babeltrace, because python bindings in babeltrace are not enabled as shown in log.do_configure:
# configure: You may configure with --enable-python-bindings if you want Python bindings.
ROS_WORLD_SKIP_GROUPS += "babeltrace-python"
# recipes depends on cwiid
ROS_WORLD_SKIP_GROUPS += "cwiid"
# recipes depends on libspnav
ROS_WORLD_SKIP_GROUPS += "libspnav"
# recipes depends on ROS_UNRESOLVED_DEP-rostime (probably the rostime from ROS1 which wasn't added to ROS2 yet)
ROS_WORLD_SKIP_GROUPS += "rostime"
# recipes depends on ROS_UNRESOLVED_DEP-message-generation (probably the message-generation from ROS1 which wasn't added to ROS2 yet)
ROS_WORLD_SKIP_GROUPS += "message-generation"
# recipes depending on legacy mongo-cxx-driver (https://packages.debian.org/source/stretch/mongo-cxx-driver-legacy)
# the mongodb recipe in meta-oe installs just the binaries mongoc, mongos, install_compass
# the header files searched by mongo-store, warehouse-ros-mongo cmake files cmake/FindMongoClient.cmake and cmake/FindMongoDB.cmake
# aren't even part of current version of mongo-cxx-driver
# src/mongo/client/dbclient.h and src/mongo/client/dbclientinterface.h are only in the legacy branches
ROS_WORLD_SKIP_GROUPS += "mongodb-legacy-cxx-driver"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
# recipes depending on 'x264' (ffmpeg does depend on it by default as well) which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'x264', 'commercial_x264'], '', 'x264', d)}"
# There is recipe for glfw in meta-oe in dunfell, but it still needs x11 in DISTRO_FEATURES
# use that in dunfell and blacklist explicitly in older releases
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'glfw', d)}"

# webots recipes depending on unavailable python moules like:
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-transforms3d-pip' (but meta-ros2-foxy/generated-recipes/webots-ros2-desktop/webots-ros2-core_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-urdf2webots-pip' (but meta-ros2-foxy/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python3-collada-pip' (but meta-ros2-foxy/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
ROS_WORLD_SKIP_GROUPS += "webots-python-modules"

# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"

# doosan-robot2 recipes depending on ROS_UNRESOLVED_DEP-controller_manager, ROS_UNRESOLVED_DEP-hardware_interface, ROS_UNRESOLVED_DEP-ament_python-native
ROS_WORLD_SKIP_GROUPS += "doosan-robot2"

# recipes depending on ros1
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'ros1-layer', '', 'ros1', d)}"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"

# recipes depending on libqglviewer (https://packages.debian.org/source/stretch/libqglviewer https://packages.debian.org/stretch/libqglviewer2-qt5)
ROS_WORLD_SKIP_GROUPS += "libqglviewer"

# recipes depending on ignition-* (ROS_UNRESOLVED_DEP-ignition-math6, ROS_UNRESOLVED_DEP-ignition-msgs5, ROS_UNRESOLVED_DEP-ignition-transport8)
ROS_WORLD_SKIP_GROUPS += "ignition"

# recipes depending on pugixml
ROS_WORLD_SKIP_GROUPS += "pugixml"

# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
ROS_WORLD_SKIP_GROUPS += "kobuki-ftdi"

# recipes depending on java from meta-java
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'meta-java', '', 'java', d)}"

# recipes depending on libomp which could be provided by openmp@meta-clang
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', '', 'libomp', d)}"

# do_configure failures
ROS_WORLD_SKIP_GROUPS += " \
    lanelet2-traffic-rules \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    mrpt2 \
    qt-gui-cpp \
"

# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
# We want ament_cmake instead of plain cmake for ros-workspace:
# https://raw.github.com/ros2-gbp/ros_workspace-release/release/foxy/ros_workspace/1.0.1-1/package.xml
ROS_BUILD_TYPE:pn-ros-workspace = "ament_cmake"

# Used by generated-recipes/cyclonedds/cyclonedds_0.7.0-1.bb:
ROS_UNRESOLVED_DEP-java-native = ""
ROS_UNRESOLVED_DEP-maven-native = ""

ROS_UNRESOLVED_DEP-spirv-headers = "spirv-headers"
ROS_UNRESOLVED_DEP-spirv-tools = "spirv-tools"
ROS_UNRESOLVED_DEP-libvulkan-dev = "vulkan-headers"
