package com.zse.hh22.user.api;

public record ChangePasswordDTO(String oldPassword, String newPassword, String repeatNewPassword) {
}
