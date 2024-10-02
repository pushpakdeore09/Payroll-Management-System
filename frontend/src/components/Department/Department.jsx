import { Divider, Grid2, TextField, Button, Table, TableHead, TableBody, TableRow, TableCell, IconButton, Typography } from '@mui/material';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import React, { useState } from 'react';
import AddDepartmentModal from './AddDepartmentModal';
import SearchEmployeeModal from './SearchEmployee';

const Department = () => {
  const [isSearched, setIsSearched] = useState(false);
  const [searchResult, setSearchResult] = useState([]);
  const [departmentName, setDepartmentName] = useState(""); 
  const [openAddDepartmentModal, setOpenAddDepartmentModal] = useState(false);
  const [openSearchEmployeeModal, setOpenSearchEmployeeModal] = useState(false);

  const handleOpenDepartmentAddModal = () => {
    setOpenAddDepartmentModal(true);
  }

  const handleCloseAddDepartmentModal = () => {
    setOpenAddDepartmentModal(false);
  }

  const handleOpenSearchEmployeeModal = () => {
    setOpenSearchEmployeeModal(true);
  }

  const handleCloseSearchEmployeeModal = () => {
    setOpenSearchEmployeeModal(false);
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
              
              value={departmentName} 
              onChange={(e) => setDepartmentName(e.target.value)} 
            />
          </Grid2>
          <Grid2 item xs={2}>
            <Button 
              variant="contained" 
              color="primary" 
              fullWidth 
              onClick={() => {
                setIsSearched(true);
                
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

        {isSearched && searchResult.length > 0 ? (
          <Table style={{ marginTop: '20px' }}>
            <TableHead>
              <TableRow>
                <TableCell>Name</TableCell>
                <TableCell>Edit</TableCell>
                <TableCell>Delete</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {searchResult.map((dept, index) => (
                <TableRow key={index}>
                  <TableCell>{dept.name}</TableCell>
                  <TableCell>
                    <IconButton>
                      <EditIcon />
                    </IconButton>
                  </TableCell>
                  <TableCell>
                    <IconButton>
                      <DeleteIcon />
                    </IconButton>
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        ) : isSearched ? (
          <Typography variant="h6" color="error" style={{ marginTop: '20px' }}>
            Department not exist
          </Typography>
        ) : null}
      </div>
      <div>
        <AddDepartmentModal handleClose={handleCloseAddDepartmentModal} open={openAddDepartmentModal}/>
      </div>
      <div>
        <SearchEmployeeModal handleClose={handleCloseSearchEmployeeModal} open={openSearchEmployeeModal} />
      </div>
    </>
  );
};

export default Department;
