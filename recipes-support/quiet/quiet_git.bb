SUMMARY = "Quiet Modem"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0da3ab9bb540414e574cbb2f96abcd81"
HOMEPAGE = "http://www.rowetel.com/wordpress/?page_id=452"

DEPENDS += " \
    liquid-dsp \
    jansson \
    portaudio-v19 \
    libsndfile1 \
"

inherit cmake

SRCREV="${AUTOREV}"

SRC_URI = " \
    git://github.com/quiet/quiet.git \
"

S = "${WORKDIR}/git"

OECMAKE_GENERATOR = "Unix Makefiles"
# EXTRA_OECMAKE += "-DUNITTEST=OFF -DCMAKE_CROSSCOMPILING=ON"

# PACKAGECONFIG ??= "tcp"
# PACKAGECONFIG[tcp] = "-Dtcp=true,-Dtcp=false"

do_install_append() {
    # libmpdclient's Vala bindings are outdated and unmaintained; it
    # is likely that nobody will ever use them, so let's not install
    # them
    # rm -rf ${D}${datadir}/vala
}

INSANE_SKIP_${PN}-dev += "dev-elf"
