import React, { useEffect, useRef, useState } from "react";
import {
  Typography,
  Divider,
  TextField,
  Button,
  Radio,
  RadioGroup,
  FormControlLabel,
  MenuItem,
} from "@mui/material";
import { Formik, Form, Field } from "formik";
import { fetchAllDept } from "../api/deptApi";
import { addEmployee } from "../api/employeeApi";
import { toast } from "react-toastify";

const AddEmployee = () => {

  const initialValues = {
    firstName: "",
    lastName: "",
    gender: "",
    dob: "",
    address: "",
    email: "",
    designation: "",
    joiningDate: "",
    employeeType: "",
    baseSalary: "",
    department: "",
  }
  const employeeTypes = [
    { value: "full-time", label: "Full-Time" },
    { value: "part-time", label: "Part-Time" },
    { value: "contract", label: "Contract" },
    { value: "intern", label: "Intern" },
  ];

  const [departments, setDepartments] = useState([]);
  const [selectedDepartment, setSelectedDepartment] = useState("");


  useEffect(() => {
    const getAllDepartments = async () => {
      try {
        const response = await fetchAllDept();
        setDepartments(response.data);
      } catch (error) {
        console.error("Error fetching departments:", error);
      }
    };

    getAllDepartments();
  }, []);

  const handleSave = async (values) => {
    const employeeData = {
      ...values,
      department: selectedDepartment, 
    };
    
    try {
      const response = await addEmployee(employeeData);
      toast.success(response.data, {autoClose: 2000});
    } catch (error) {
      toast.error(error.response.data, {autoClose: 2000})
    }
  };

  

  return (
    <>
      <div className="flex flex-col p-4 space-y-6">
        <Typography variant="h4" className="text-3xl font-bold mb-4">
          Add Employee
        </Typography>
        <Divider sx={{ height: 4, bgcolor: "gray" }} />

        <Formik
          initialValues={initialValues}
          onSubmit={handleSave}
        >
          {({ setFieldValue }) => (
            <Form className="grid grid-cols-2 gap-6">
              <div className="col-span-2">
                <Field
                  as={TextField}
                  fullWidth
                  label="Select Department"
                  select
                  value={selectedDepartment}
                  onChange={(e) => {
                    const departmentName = e.target.value;
                    setSelectedDepartment(departmentName);
                    setFieldValue("department", departmentName); 
                  }}
                >
                  <MenuItem value="">Select Department</MenuItem>
                  {departments.map((department, index) => (
                    <MenuItem key={index} value={department.deptId}>
                      {department.deptName}
                    </MenuItem>
                  ))}
                </Field>
              </div>

              <div>
                <Field
                  as={TextField}
                  name="firstName"
                  fullWidth
                  label="First Name"
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("firstName", e.target.value); 
                  }}
                />
              </div>
              <div>
                <Field
                  as={TextField}
                  name="lastName"
                  fullWidth
                  label="Last Name"
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("lastName", e.target.value); 
                  }}
                />
              </div>

              <div>
                <Typography variant="body1" gutterBottom>
                  Gender
                </Typography>
                <Field
                  as={RadioGroup}
                  row
                  name="gender"
                  onChange={(e) => {
                    const value = e.target.value;
                    setFieldValue("gender", value); 
                  }}
                >
                  <FormControlLabel value="male" control={<Radio />} label="Male" />
                  <FormControlLabel
                    value="female"
                    control={<Radio />}
                    label="Female"
                  />
                  <FormControlLabel
                    value="other"
                    control={<Radio />}
                    label="Other"
                  />
                </Field>
              </div>
              <div>
                <Field
                  as={TextField}
                  name="dob"
                  fullWidth
                  type="date"
                  label="Date of Birth"
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
                  name="address"
                  fullWidth
                  label="Address"
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("address", e.target.value); 
                  }}
                />
              </div>
              <div>
                <Field
                  as={TextField}
                  name="email"
                  fullWidth
                  label="Email"
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("email", e.target.value); 
                  }}
                />
              </div>
              <div>
                <Field
                  as={TextField}
                  name="designation"
                  fullWidth
                  label="Designation"
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("designation", e.target.value); 
                  }}
                />
              </div>
              <div>
                <Field
                  as={TextField}
                  name="joiningDate"
                  fullWidth
                  type="date"
                  label="Joining Date"
                  InputLabelProps={{ shrink: true }}
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("joiningDate", e.target.value); 
                  }}
                />
              </div>
              <div>
                <Field
                  as={TextField}
                  name="employeeType"
                  fullWidth
                  label="Employee Type"
                  select
                  onChange={(e) => {
                    setFieldValue("employeeType", e.target.value); 
                  }}
                >
                  {employeeTypes.map((option) => (
                    <MenuItem key={option.value} value={option.value}>
                      {option.label}
                    </MenuItem>
                  ))}
                </Field>
              </div>
              <div>
                <Field
                  as={TextField}
                  name="baseSalary"
                  fullWidth
                  type="number"
                  label="Base Salary"
                  variant="outlined"
                  onChange={(e) => {
                    setFieldValue("baseSalary", e.target.value); 
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

export default AddEmployee;
