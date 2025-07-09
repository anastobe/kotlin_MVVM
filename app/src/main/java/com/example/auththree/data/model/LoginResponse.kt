package com.example.auththree.data.model
//
//data class LoginResponse(
//    var token: String? = null,
//    var two_factor: String? = null
//)
data class LoginResponse(
    val token: String?,
    val two_factor: String?,
    val user: LoginUser?     // ✅ use renamed class
)

data class LoginUser(
    val company_id: String?,
    val user_id: String?,
    val emp_code: String?,
    val full_name: String?,
    val email_address: String?,
    val phone_number: String?,
    val user_type: String?,
    val designation_id: String?,
    val role_name: String?,
    val branch_name: String?,
    val last_login_time: String?,
    val is_new_user: String?,
    val login_id: String?
)
