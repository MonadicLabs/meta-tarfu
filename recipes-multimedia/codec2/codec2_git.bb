SUMMARY = "Very low bitrate voice codec"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://COPYING;md5=776e198b48f3a1004a437be10854038b"
HOMEPAGE = "http://www.rowetel.com/wordpress/?page_id=452"

inherit cmake

SRC_URI = " \
    git://github.com/MonadicLabs/libcodec2.git \
"

SRCREV = "95036d7e5c79d4570caeca626000889397f3f571"
S = "${WORKDIR}/git"

OECMAKE_GENERATOR = "Unix Makefiles"
EXTRA_OECMAKE += "-DUNITTEST=OFF -DCMAKE_CROSSCOMPILING=ON"

# PACKAGECONFIG ??= "tcp"
# PACKAGECONFIG[tcp] = "-Dtcp=true,-Dtcp=false"

do_install_append() {
    # libmpdclient's Vala bindings are outdated and unmaintained; it
    # is likely that nobody will ever use them, so let's not install
    # them
    # rm -rf ${D}${datadir}/vala
}
