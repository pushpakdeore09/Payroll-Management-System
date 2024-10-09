import React, { useState } from "react";
import {
  TextField,
  Button,
  Typography,
  InputAdornment,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Box,
} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import { useNavigate } from "react-router-dom";
import { searchEmployee } from "../api/employeeApi";

const EmployeeManagement = () => {
  const navigate = useNavigate();
  const [searchValue, setSearchValue] = useState("");
  const [employee, setEmployee] = useState(null);
  const [searchAttempted, setSearchAttempted] = useState(false);

  const handleAddNewEmployee = () => {
    navigate("/addEmployee");
  };

  const handleEditEmployee = () => {
    navigate(`/employee/${employee.employeeId}`);
  };

  const handleSearchEmployee = async () => {
    try {
      const response = await searchEmployee(searchValue);
      setEmployee(response);
      setSearchAttempted(true);
    } catch (error) {
      setSearchAttempted(true);
      console.error("Error fetching employee data:", error);
      setEmployee(null);
    }
  };

  return (
    <div className="flex flex-col p-4">
      <Typography variant="h4" className="mb-2 text-3xl font-bold">
        Employee Dashboard
      </Typography>

      <div className="flex justify-between items-center">
        <Button
          variant="contained"
          color="primary"
          fullWidth
          size="medium"
          sx={{ width: "200px", marginBottom: "16px", marginTop: "25px" }}
          onClick={handleAddNewEmployee}
        >
          + Add New Employee
        </Button>

        <div style={{ position: "relative", width: "300px" }}>
          <TextField
            label="Search Employee"
            variant="outlined"
            size="small"
            fullWidth
            className="mb-2"
            sx={{ width: "100%" }}
            value={searchValue}
            onChange={(e) => setSearchValue(e.target.value)}
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <SearchIcon
                    style={{ cursor: "pointer" }}
                    onClick={handleSearchEmployee}
                  />
                </InputAdornment>
              ),
            }}
          />
        </div>
      </div>

      {searchAttempted && !employee ? (
        <Typography variant="h6" color="error" style={{ marginTop: "20px" }}>
          Employee not found
        </Typography>
      ) : null}

      {employee ? (
        <Box
          sx={{
            overflowX: "auto",
            boxShadow: 2,
            borderColor: "1px solid",
            borderRadius: 1,
          }}
        >
          <TableContainer
            component={Paper}
            sx={{ marginTop: 2, width: "100%", maxWidth: "100%" }}
          >
            <Table sx={{ width: "100%" }}>
              <TableHead>
                <TableRow>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Employee ID
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Name
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Designation
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Department
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Email
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Base Salary
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Joining Date
                    </Typography>
                  </TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                <TableRow>
                  <TableCell>
                    <Typography variant="h6">{employee.employeeId}</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6">
                      {employee.firstName} {employee.lastName}
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6">{employee.designation}</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6">
                      {employee.department.deptName}
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6">{employee.email}</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6">{employee.baseSalary}</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6">
                      {new Date(employee.joiningDate).toLocaleDateString()}
                    </Typography>
                  </TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </TableContainer>
          <Box
            sx={{ display: "flex", justifyContent: "flex-end", marginTop: 2 }}
          >
            <Button
              variant="contained"
              color="secondary"
              onClick={handleEditEmployee}
              sx={{ width: 200, marginRight: 2, marginBottom: 2 }}
            >
              Edit Employee
            </Button>
          </Box>
        </Box>
      ) : null}
    </div>
  );
};

export default EmployeeManagement;
