# Copyright (c) 2020 LG Electronics, Inc.

inherit ros_insane_dev_so

DEPENDS:append:class-target = " chrpath-replacement-native"
# For some reason ends with bad RPATH
# WARNING: ompl-1.5.0-1-r0 do_package_qa: QA Issue: ompl: /work/core2-64-oe-linux/ompl/1.5.0-1-r0/packages-split/ompl/usr/lib/libompl.so.1.5.0 contains probably-redundant RPATH /usr/lib [useless-rpaths]
do_install:append() {
    chrpath --delete ${D}${libdir}/*${SOLIBS}
}
