import { Button, Divider, MenuItem, TextField, Typography } from "@mui/material";
import { Field, Form, Formik } from "formik";
import React from "react";
import * as Yup from "yup";

const AddPayrollMonth = () => {
  const months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December",
  ];

  const initialValues = {
    month: "",       
    year: "",        
    startDate: "",   
    endDate: "",     
  };
  
  const validationSchema = Yup.object({
    month: Yup.string().required("Required"),
    year: Yup.number()
      .required("Required")
      .min(1900, "Year must be after 1900")
      .max(new Date().getFullYear(), "Year can't be in the future"),
    startDate: Yup.date()
      .required("Required")
      .nullable(),
    endDate: Yup.date()
      .required("Required")
      .nullable()
      .min(Yup.ref("startDate"), "End date cannot be before start date"),
  });

  const handleSubmit = (values) => {
    console.log("Submitted values:", values);
    
  }

  return (
    <>
      <div className="flex flex-col p-4 space-y-6">
        <Typography variant="h4" className="text-3xl font-bold mb-4">
          Add Payroll Month
        </Typography>
        <Divider sx={{ height: 4, bgcolor: "gray" }} />
      </div>
      <div className="flex flex-col p-4 space-y-6">
        <Formik
          validationSchema={validationSchema}
          initialValues={initialValues}
          onSubmit={handleSubmit}
        >
          {({ setFieldValue, errors, touched }) => (
            <Form className="grid grid-cols-2 gap-6">
              <div className="grid grid-cols-2 gap-6 col-span-2">
                <Field
                  as={TextField}
                  fullWidth
                  label="Select Month"
                  size="small"
                  select
                  name="month"  // Added name prop
                  onChange={(e) => setFieldValue("month", e.target.value)}
                  error={touched.month && Boolean(errors.month)}
                  helperText={touched.month && errors.month}
                >
                  <MenuItem value="">Select Month</MenuItem>
                  {months.map((month, index) => (
                    <MenuItem key={index} value={month}>
                      {month}
                    </MenuItem>
                  ))}
                </Field>
                <Field
                  as={TextField}
                  fullWidth
                  name="year"
                  label="Year"
                  size="small"
                  type="number"
                  onChange={(e) => setFieldValue("year", e.target.value)}
                  error={touched.year && Boolean(errors.year)}
                  helperText={touched.year && errors.year}
                />
              </div>

              <div>
                <Field
                  as={TextField}
                  name="startDate"  // Changed to "startDate"
                  fullWidth
                  type="date"
                  label="Start Date"
                  InputLabelProps={{ shrink: true }}
                  variant="outlined"
                  onChange={(e) => setFieldValue("startDate", e.target.value)}
                  error={touched.startDate && Boolean(errors.startDate)}
                  helperText={touched.startDate && errors.startDate}
                />
              </div>
              <div>
                <Field
                  as={TextField}
                  name="endDate"  // Changed to "endDate"
                  fullWidth
                  type="date"
                  label="End Date"
                  InputLabelProps={{ shrink: true }}
                  variant="outlined"
                  onChange={(e) => setFieldValue("endDate", e.target.value)}
                  error={touched.endDate && Boolean(errors.endDate)}
                  helperText={touched.endDate && errors.endDate}
                />
              </div>

              <div className="flex justify-center col-span-2">
                <Button type="submit" variant="contained" color="primary">
                  Save
                </Button>
              </div>
            </Form>
          )}
        </Formik>
      </div>
    </>
  );
};

export default AddPayrollMonth;
