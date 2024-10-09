import { Button, Divider, MenuItem, TextField, Typography } from "@mui/material";
import { Field, Form, Formik } from "formik";
import React, { useState } from "react";

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

  const [selectedMonth, setSelectedMonth] = useState("");
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
        //initialValues={}
        //onSubmit={handleSubmit}
        >
          {({ setFieldValue }) => (
            <Form className="grid grid-cols-2 gap-6">
              <div className="col-span-2">
                <Field
                  as={TextField}
                  fullWidth
                  label="Select Month"
                  size="small"
                  select
                  value={selectedMonth}
                  onChange={(e) => {
                    const monthName = e.target.value;
                    setSelectedMonth(monthName);
                    setFieldValue("month", monthName);
                  }}
                >
                  <MenuItem value="">Select Month</MenuItem>
                  {months.map((month, index) => (
                    <MenuItem key={index} value={month}>
                      {month}
                    </MenuItem>
                  ))}
                </Field>
              </div>
              <div>
                <Field
                  as={TextField}
                  name="dob"
                  fullWidth
                  type="date"
                  label="Start Date"
                  InputLabelProps={{ shrink: true }}
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("dob", e.target.value); 
                  }}
                />
              </div>
              <div>
                <Field
                  as={TextField}
                  name="dob"
                  fullWidth
                  type="date"
                  label="End Date"
                  InputLabelProps={{ shrink: true }}
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("dob", e.target.value); 
                  }}
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
