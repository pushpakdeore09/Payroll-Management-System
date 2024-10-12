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
  Divider,
  Grid2,
  IconButton,
} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import { useNavigate } from "react-router-dom";
import { getAllEmployees, searchEmployee } from "../api/employeeApi";
import { toast } from "react-toastify";

const EmployeeManagement = () => {
  const navigate = useNavigate();
  const [searchValue, setSearchValue] = useState("");
  const [employees, setEmployees] = useState([]);
  const [searchAttempted, setSearchAttempted] = useState(false);

  const handleAddNewEmployee = () => {
    navigate("/addEmployee");
  };

  const handleEditEmployee = (employeeId) => {
    navigate(`/employee/${employeeId}`);
  };

  const handleSearchEmployee = async () => {
    try {
      const response = await searchEmployee(searchValue);
      setEmployees(response ? [response] : []);
      setSearchAttempted(true);
    } catch (error) {
      setSearchAttempted(true);
      console.error("Error fetching employee data:", error);
      setEmployees([]);
    }
  };

  const handleGetAllEmployees = async () => {
    try {
      const response = await getAllEmployees();
      if (response.data && response.data.length > 0) {
        setEmployees(response.data);
      } else {
        toast.error("No employees found", { autoClose: 2000 });
        setEmployees([]);
      }
    } catch (error) {
      console.error("Error loading employees:", error);
    }
  };

  return (
    <div className="flex flex-col p-4">
      <div className="flex flex-col space-y-6">
        <Typography variant="h4" className="text-3xl font-bold mb-4">
          Employee Dashboard
        </Typography>
        <Divider sx={{ height: 4, bgcolor: "gray" }} />
      </div>

      <Grid2
        container
        spacing={2}
        alignItems="flex-start"
        sx={{ marginTop: 2 }}
      >
        <Grid2 item xs={10}>
          <TextField
            required
            label="Enter Employee ID"
            variant="outlined"
            size="small"
            fullWidth
            InputProps={{
              endAdornment: (
                <InputAdornment position="end">
                  <IconButton onClick={handleSearchEmployee}>
                    <SearchIcon />
                  </IconButton>
                </InputAdornment>
              ),
            }}
            onChange={(e) => setSearchValue(e.target.value)} // Capture input value
          />
        </Grid2>

        <Grid2 item xs={2}>
          <Button
            variant="contained"
            color="secondary"
            fullWidth
            onClick={handleAddNewEmployee}
          >
            Add New Employee
          </Button>
        </Grid2>
        
        <Grid2 item xs={2}>
          <Button
            variant="contained"
            color="primary"
            fullWidth
            onClick={handleGetAllEmployees}
          >
            Get All Employees
          </Button>
        </Grid2>
      </Grid2>

      {searchAttempted && employees.length === 0 && (
        <Typography variant="h6" color="error" style={{ marginTop: "20px" }}>
          Employee not found
        </Typography>
      )}

      {employees.length > 0 && (
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
                {employees.map(emp => (
                  <TableRow key={emp.employeeId}>
                    <TableCell>
                      <Typography variant="h6">{emp.employeeId}</Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">
                        {emp.firstName} {emp.lastName}
                      </Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">{emp.designation}</Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">
                        {emp.department.deptName}
                      </Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">{emp.email}</Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">{emp.baseSalary}</Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">
                        {new Date(emp.joiningDate).toLocaleDateString()}
                      </Typography>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
          <Box
            sx={{ display: "flex", justifyContent: "flex-end", marginTop: 2 }}
          >
            <Button
              variant="contained"
              color="secondary"
              onClick={() => handleEditEmployee(employees[0].employeeId)} // Edit the first employee in the array
              sx={{ width: 200, marginRight: 2, marginBottom: 2 }}
            >
              Edit Employee
            </Button>
          </Box>
        </Box>
      )}
    </div>
  );
};

export default EmployeeManagement;
