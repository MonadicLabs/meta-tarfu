DESCRIPTION="Upstream's U-boot configured for sunxi devices"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR = "tarfu0"

SRC_URI += " \
  file://boot_patched.cmd \
  file://orangepi_zero_defconfig_patched \
"

do_configure_prepend() {
  cat ${WORKDIR}/boot_patched.cmd > ${WORKDIR}/boot.cmd
  cat ${WORKDIR}/orangepi_zero_defconfig_patched > ${WORKDIR}/git/configs/orangepi_zero_defconfig
}

do_compile_append() {
    ${B}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/boot.cmd ${WORKDIR}/${UBOOT_ENV_BINARY}
}
