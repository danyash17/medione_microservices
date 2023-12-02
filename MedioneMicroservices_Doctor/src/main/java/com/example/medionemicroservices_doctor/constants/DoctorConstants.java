package com.example.medionemicroservices_doctor.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DoctorConstants {

    public static final String DOCTOR_UPDATED = "Doctor updated successfully";
    public static final String DOCTOR_FAIL_UPDATE = "Doctor update failed";

    public static final String DOCTOR_DELETED = "Doctor deleted successfully";
    public static final String DOCTOR_FAIL_DELETE = "Doctor delete failed";

}
