import React from "react";
import { TextField, Button, Typography } from "@mui/material";

const EmployeeManagement = () => {
  return (
    <div className="flex flex-col p-4">
      <Typography variant="h5" className="mb-2 text-3xl font-bold">
        Employee Dashboard
      </Typography>

      <div className="flex justify-between">
        <Button
          variant="contained"
          color="primary"
          fullWidth
          size="small"
          sx={{ width: "200px", marginTop:"25px"}}
        >
          + Add New Employee
        </Button>

        <TextField
          label="Search Employee"
          variant="outlined"
          size="small"
          fullWidth
          className="mb-2"
          sx={{ width: "200px", display: "flex", alignItems: "flex-end" }}
        />
      </div>
    </div>
  );
};

export default EmployeeManagement;
