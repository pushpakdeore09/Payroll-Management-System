import {
  Button,
  Divider,
  MenuItem,
  TextField,
  Typography,
} from "@mui/material";
import { Field, Form, Formik } from "formik";
import React, { useState } from "react";
import * as Yup from "yup";
import { addDeductions } from "../api/deductionApi";
import { toast } from "react-toastify";

const AddDeductions = () => {
  const allowanceTypes = ["Statutory Deduction", "Voluntary Deduction"];
  const initialValues = {
    deductionName: "",
    employeeId: "",
    deductionType: "",
    deductionPercentage: "",
  };

  const validationSchema = Yup.object().shape({
    deductionName: Yup.string()
      .required("Deduction name is required")
      .min(3, "Deduction name must be at least 3 characters"),
    employeeId: Yup.string()
      .required("Employee ID is required")
      .matches(/^[0-9]+$/, "Employee ID must be a number"),
    deductionType: Yup.string().required("Deduction Type is required"),
    deductionPercentage: Yup.number()
      .required("Deduction Percentage is required")
      .min(0, "Deduction percentage cannot be negative")
      .max(100, "Deduction percentage cannot exceed 100"),
  });

  const handleSave = async (values) => {
    try {
      const response = await addDeductions(values);
      toast.success(response.data, { autoClose: 2000 });
    } catch (error) {
      const errorMessage = error.response?.data;
      toast.error(errorMessage, { autoClose: 2000 });
    }
  };
  

  return (
    <div className="flex flex-col p-4 space-y-6">
      <Typography variant="h4" className="text-3xl font-bold mb-4">
        Add Deduction
      </Typography>
      <Divider sx={{ height: 4, bgcolor: "gray" }} />

      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={handleSave}
      >
        {({ handleSubmit, touched, errors }) => (
          <Form className="grid grid-cols-2 gap-6" onSubmit={handleSubmit}>
            <div>
              <Field
                as={TextField}
                fullWidth
                label="Deductions Name"
                name="deductionName"
                variant="outlined"
                error={touched.allowanceName && !!errors.allowanceName}
                helperText={touched.allowanceName && errors.allowanceName}
              />
            </div>
            <div>
              <Field
                as={TextField}
                fullWidth
                label="Employee ID"
                name="employeeId"
                variant="outlined"
                error={touched.employeeId && !!errors.employeeId}
                helperText={touched.employeeId && errors.employeeId}
              />
            </div>

            <div>
              <Field
                as={TextField}
                fullWidth
                select
                label="Deductions Type"
                name="deductionType"
                variant="outlined"
                error={touched.allowanceType && !!errors.allowanceType}
                helperText={touched.allowanceType && errors.allowanceType}
              >
                <MenuItem value="">Select Allowance Type</MenuItem>
                {allowanceTypes.map((allowanceType, index) => (
                  <MenuItem key={index} value={allowanceType}>
                    {allowanceType}
                  </MenuItem>
                ))}
              </Field>
            </div>
            <div>
              <Field
                as={TextField}
                fullWidth
                label="Deductions Percentage"
                name="deductionPercentage"
                type="number"
                variant="outlined"
                error={
                  touched.allowancePercentage && !!errors.allowancePercentage
                }
                helperText={
                  touched.allowancePercentage && errors.allowancePercentage
                }
              />
            </div>

            <div className="col-span-2 flex justify-center">
              <Button type="submit" variant="contained" color="primary" onClick={handleSave}>
                Save Deduction
              </Button>
            </div>
          </Form>
        )}
      </Formik>
    </div>
  );
};

export default AddDeductions;
