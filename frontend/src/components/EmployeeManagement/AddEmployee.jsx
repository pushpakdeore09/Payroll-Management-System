import React, { useEffect, useState } from "react";
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

const AddEmployee = () => {
  const employeeTypes = [
    { value: "full-time", label: "Full-Time" },
    { value: "part-time", label: "Part-Time" },
    { value: "contract", label: "Contract" },
    { value: "intern", label: "Intern" },
  ];

  const [departments, setDepartments] = useState([]);
  const [selectedDepartment, setSelectedDepartment] = useState("");


  useEffect(() => {});

  const handleSave = () => {
    // Save or submit the employee data logic
  };

  return (
    <>
      <div className="flex flex-col p-4 space-y-6"
      style={{height:'100vh',overflowY:'scroll', padding:'16px'}}>
        <Typography variant="h4" className="text-3xl font-bold mb-4">
          Add New Employee
        </Typography>
        <Divider sx={{ height: 4, bgcolor: "gray" }} />

        <div className="grid grid-cols-2 gap-6">
          <div className="col-span-2">
            <TextField
              fullWidth
              label="Select Department"
              select
              value={selectedDepartment}
            >
              <MenuItem value="">Select Department</MenuItem>
              {departments.map((department) => {
                <MenuItem key={department.id} value={department.id}>
                  {department.name}
                </MenuItem>;
              })}
            </TextField>
          </div>

          <div>
            <TextField fullWidth label="First Name" variant="outlined" />
          </div>
          <div>
            <TextField fullWidth label="Last Name" variant="outlined" />
          </div>

          {/* Gender and Date of Birth */}
          <div>
            <Typography variant="body1" gutterBottom>
              Gender
            </Typography>
            <RadioGroup row>
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
            </RadioGroup>
          </div>
          <div>
            <TextField
              fullWidth
              type="date"
              label="Date of Birth"
              InputLabelProps={{ shrink: true }}
              variant="outlined"
            />
          </div>

          {/* Address Section */}
          <div>
            <TextField fullWidth label="Address" variant="outlined" />
          </div>
          <div>
            <TextField fullWidth label="Email" variant="outlined" />
          </div>
          <div>
            <TextField fullWidth label="Designation" variant="outlined" />
          </div>
          <div>
            <TextField
              fullWidth
              type="date"
              label="Joining Date"
              InputLabelProps={{ shrink: true }}
              variant="outlined"
            />
          </div>
          <div>
            <TextField
              fullWidth
              label="Employee Type"
              select
            >
              {employeeTypes.map((option) => (
                <MenuItem key={option.value} value={option.value}>
                  {option.label}
                </MenuItem>
              ))}
            </TextField>
          </div>
          <div>
            <TextField
            fullWidth
            label='Phone'
            variant="outlined"

            />
          </div>
        </div>

        {/* Save Button */}
        <div className="flex justify-center">
          <Button variant="contained" color="primary" onClick={handleSave}>
            Save
          </Button>
        </div>
      </div>
    </>
  );
};

export default AddEmployee;
