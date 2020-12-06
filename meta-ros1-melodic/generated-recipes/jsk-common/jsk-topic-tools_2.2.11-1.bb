# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "jsk_topic_tools"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
HOMEPAGE = "http://ros.org/wiki/jsk_topic_tools"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "jsk_common"
ROS_BPN = "jsk_topic_tools"

ROS_BUILD_DEPENDS = " \
    diagnostic-msgs \
    diagnostic-updater \
    dynamic-reconfigure \
    dynamic-tf-publisher \
    eigen-conversions \
    geometry-msgs \
    image-transport \
    message-generation \
    nodelet \
    roscpp \
    roslaunch \
    rosnode \
    rostest \
    rostime \
    rostopic \
    std-msgs \
    std-srvs \
    tf \
    topic-tools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${PYTHON_PN}-numpy \
    ${ROS_UNRESOLVED_DEP-python-scipy} \
    diagnostic-msgs \
    diagnostic-updater \
    dynamic-reconfigure \
    dynamic-tf-publisher \
    eigen-conversions \
    geometry-msgs \
    image-transport \
    message-runtime \
    nodelet \
    opencv \
    roscpp \
    roslaunch \
    rosnode \
    rostime \
    rostopic \
    sensor-msgs \
    sound-play \
    std-msgs \
    std-srvs \
    tf \
    topic-tools \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roscpp-tutorials \
    roslint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/jsk_common-release/archive/release/melodic/jsk_topic_tools/2.2.11-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/jsk_topic_tools"
SRC_URI = "git://github.com/tork-a/jsk_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "b6057508d057135d65dfc7ec4e294e303fde8c25"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
