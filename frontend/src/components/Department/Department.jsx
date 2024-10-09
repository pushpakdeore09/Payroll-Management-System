import {
  Divider,
  Grid2,
  TextField,
  Button,
  Table,
  TableHead,
  TableBody,
  TableRow,
  TableCell,
  IconButton,
  Typography,
  Box,
  InputAdornment,
} from "@mui/material";
import EditIcon from "@mui/icons-material/Edit";
import DeleteIcon from "@mui/icons-material/Delete";
import React, { useState } from "react";
import AddDepartmentModal from "./AddDepartmentModal";
import { deleteDepartment, getAllDept, getDeptByName } from "../api/deptApi";
import { toast } from "react-toastify";

const Department = () => {
  const [openAddDepartmentModal, setOpenAddDepartmentModal] = useState(false);
  const [departments, setDepartments] = useState([]);
  const [searchInput, setSearchInput] = useState("");

  const handleOpenDepartmentAddModal = () => {
    setOpenAddDepartmentModal(true);
  };

  const handleCloseAddDepartmentModal = () => {
    setOpenAddDepartmentModal(false);
  };

  const handleSearchChange = (event) => {
    setSearchInput(event.target.value);
  };

  const handleSearch = async (searchInput) => {
    console.log(searchInput);

    try {
      const response = await getDeptByName(searchInput);
      setDepartments(response.data);
      console.log("dept", response);
    } catch (error) {
      toast.error(error.response.data, { autoClose: 2000 });
    }
  };

  const handleDeleteDept = async (deptId) => {
    try {
      const response = await deleteDepartment(deptId);
      toast.success(response, { autoClose: 2000 });
      setDepartments((prevDepartments) =>
        prevDepartments.filter((department) => department.deptId !== deptId)
      );
    } catch (error) {
      console.log("error", error);
    }
  };

  const handleShowDept = async () => {
    try {
      const response = await getAllDept();
      setDepartments(response.data);
    } catch (error) {
      toast.error("No departments found", { autoClose: 2000 });
    }
  };

  return (
    <>
      <div className="flex flex-col">
        <Typography variant="h4" className="text-3xl font-bold mb-2 p-4">
          Department Dashboard
        </Typography>
        <Divider />
      </div>
      <div style={{ padding: "20px" }}>
        <Grid2 container spacing={2} alignItems="flex-end">
          <Grid2 item xs={10} size={8}>
              <TextField
                readOnly
                label="Department Name"
                variant="outlined"
                size="small"
                fullWidth
                value={searchInput}
                onChange={handleSearchChange}
              />
          </Grid2>

          <Grid2 item xs={2}>
            <Button
              variant="contained"
              color="primary"
              fullWidth
              onClick={handleShowDept}
            >
              Show
            </Button>
          </Grid2>
          <Grid2 item xs={2}>
            <Button
              variant="contained"
              color="secondary"
              fullWidth
              onClick={handleOpenDepartmentAddModal}
            >
              Add New
            </Button>
          </Grid2>
        </Grid2>

        {departments.length > 0 ? (
          <Box
            sx={{
              mt: 2,
              p: 2,
              border: "1px solid",
              borderColor: "grey.300",
              borderRadius: 1,
              boxShadow: 2,
            }}
          >
            <Table sx={{ fontSize: "1.2rem" }} style={{ marginTop: "20px" }}>
              <TableHead>
                <TableRow>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Dept ID
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Name
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      No. of Employees
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Edit
                    </Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">
                      Delete
                    </Typography>
                  </TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {departments.map((department, index) => (
                  <TableRow key={index}>
                    <TableCell>
                      <Typography variant="h6">{department.deptId}</Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">
                        {department.deptName}
                      </Typography>
                    </TableCell>
                    <TableCell>
                      <Typography variant="h6">
                        {department.numOfEmployees !== null &&
                        department.numOfEmployees !== undefined
                          ? department.numOfEmployees
                          : 0}
                      </Typography>
                    </TableCell>
                    <TableCell>
                      <IconButton>
                        <EditIcon />
                      </IconButton>
                    </TableCell>
                    <TableCell>
                      <IconButton
                        onClick={() => handleDeleteDept(department.deptId)}
                      >
                        <DeleteIcon />
                      </IconButton>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </Box>
        ) : (
          <Typography variant="h6" color="error" style={{ marginTop: "20px" }}>
            Departments not found
          </Typography>
        )}
      </div>
      <div>
        <AddDepartmentModal
          handleClose={handleCloseAddDepartmentModal}
          open={openAddDepartmentModal}
        />
      </div>
    </>
  );
};

export default Department;
