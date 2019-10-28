SUMMARY = "TARFU image for Orange Pi Zero"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
  u-boot-opi \
  openssh openssh-keygen \
  kernel-modules \
  xradio \
  quiet \
"

EXTRA_TOOLS_INSTALL = " \
  mtd-utils \
"

IMAGE_INSTALL += " \
  ${CORE_OS} \
  ${EXTRA_TOOLS_INSTALL} \
"

IMAGE_FEATURES += "package-management"
