# Copyright (c) 2021 Wind River, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-add-include-string.patch \
    file://0002-add-include-cstdio.patch \
    file://0003-comment-out-some-installs.patch \
"

