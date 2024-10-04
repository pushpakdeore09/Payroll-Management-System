import { Divider, Grid2, TextField, Button, Table, TableHead, TableBody, TableRow, TableCell, IconButton, Typography, Box } from '@mui/material';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import React, { useState } from 'react';
import AddDepartmentModal from './AddDepartmentModal';
import SearchEmployeeModal from './SearchEmployee';
import { getAllDept } from '../api/deptApi';
import { toast } from 'react-toastify';

const Department = () => {
  const [isSearched, setIsSearched] = useState(false);
  const [openAddDepartmentModal, setOpenAddDepartmentModal] = useState(false);
  const [openSearchEmployeeModal, setOpenSearchEmployeeModal] = useState(false);
  const [departments, setDepartments] = useState([]);

  const sampleDepartments = [
    { deptId: 1, name: 'HR', numOfEmployees: 15 },
    { deptId: 2, name: 'IT', numOfEmployees: 25 },
    { deptId: 3, name: 'Finance', numOfEmployees: 10 },
  ];

  const handleOpenDepartmentAddModal = () => {
    setOpenAddDepartmentModal(true);
  };

  const handleCloseAddDepartmentModal = () => {
    setOpenAddDepartmentModal(false);
  };

  const handleOpenSearchEmployeeModal = () => {
    setOpenSearchEmployeeModal(true);
  };

  const handleCloseSearchEmployeeModal = () => {
    setOpenSearchEmployeeModal(false);
  };

  const handleDeleteDept = () => {

  }
  
  const handleShowDept = async () => {
    try {
      const response = await getAllDept();
      setDepartments(response.data);
    } catch (error) {
      toast.error("No departments found", {autoClose: 2000});
    }
  }

  return (
    <>
      <div className='flex flex-col'>
        <Typography variant='h4' className='text-3xl font-bold mb-2 p-4'>
          Department Dashboard
        </Typography>
        <Divider />
      </div>
      <div style={{ padding: '20px' }}>
        <Grid2 container spacing={2} alignItems="flex-end"> 
          <Grid2 item xs={10} size={8}>
            <TextField
              readOnly
              label="Department Name"
              variant="outlined"
              size='small'
              fullWidth
            />
          </Grid2>
          <Grid2 item xs={2}>
            <Button 
              variant="contained" 
              color="primary" 
              fullWidth 
              onClick={() => {
                setIsSearched(true)
              }}>
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
          <Grid2 item xs={2}>
            <Button
              variant="contained"
              color="primary"
              fullWidth
              onClick={handleOpenSearchEmployeeModal}
            >
              Search
            </Button>
          </Grid2>
        </Grid2>

        {isSearched && sampleDepartments.length > 0 ? (
          <Box sx={{ mt: 2, p: 2, border: '1px solid', borderColor: 'grey.300', borderRadius: 1, boxShadow: 2 }}>
            <Table sx={{ fontSize: '1.2rem' }} style={{ marginTop: '20px' }}>
              <TableHead>
                <TableRow>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">Dept ID</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">Name</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">No. of Employees</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">Edit</Typography>
                  </TableCell>
                  <TableCell>
                    <Typography variant="h6" fontWeight="bold">Delete</Typography>
                  </TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {departments.map((department, index) => (
                  <TableRow key={index}>
                    <TableCell>{department.deptId}</TableCell>
                    <TableCell>{department.deptName}</TableCell>
                    <TableCell>{department.numOfEmployees}</TableCell>
                    <TableCell>
                      <IconButton>
                        <EditIcon />
                      </IconButton>
                    </TableCell>
                    <TableCell>
                      <IconButton>
                        <DeleteIcon onClick={handleDeleteDept}/>
                      </IconButton>
                    </TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>
          </Box>
        ) : isSearched ? (
          <Typography variant="h6" color="error" style={{ marginTop: '20px' }}>
            Department does not exist
          </Typography>
        ) : null}
      </div>
      <div>
        <AddDepartmentModal handleClose={handleCloseAddDepartmentModal} open={openAddDepartmentModal} />
      </div>
      <div>
        <SearchEmployeeModal handleClose={handleCloseSearchEmployeeModal} open={openSearchEmployeeModal} />
      </div>
    </>
  );
};

export default Department;
