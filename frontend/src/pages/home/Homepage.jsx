import React, { useState } from 'react';
import { Typography, Avatar, Menu, MenuItem, IconButton, Divider, Box, Grid, Card, CardContent, Grid2 } from '@mui/material';
import PersonIcon from '@mui/icons-material/Person';

const Homepage = () => {
  const [anchorEl, setAnchorEl] = useState(null);
  const open = Boolean(anchorEl);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

  const handleLogout = () => {
    
  }

  return (
    <>
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between', padding: '20px' }}>
        <div className='mt-5 ml-5'>
          <Typography variant='h3' className='text-2xl'>Welcome</Typography>
        </div>
        <div className='mr-5'>
          <IconButton onClick={handleClick}>
            <Avatar 
              sx={{ width: 50, height: 50, cursor: 'pointer' }} 
            >
              <PersonIcon sx={{ fontSize: 30 }} /> 
            </Avatar>
          </IconButton>
          <Menu
            anchorEl={anchorEl}
            open={open}
            onClose={handleClose}
            anchorOrigin={{
              vertical: 'bottom',
              horizontal: 'right',
            }}
            transformOrigin={{
              vertical: 'top',
              horizontal: 'right',
            }}
          >
            <MenuItem onClick={handleLogout}>Logout</MenuItem>
          </Menu>
        </div>
      </div>
      <Divider sx={{ height: 5, bgcolor: 'black', margin: '10px 0' }} />

      <Box sx={{ padding: '20px' }}>
        <Typography variant="h4" className='text-center' gutterBottom>
          Payroll Management System
        </Typography>
        <Typography variant="h6" className='text-center' gutterBottom>
          This system allows you to manage employee payroll efficiently, including features for:
        </Typography>

        <Grid2 container spacing={3}>
          <Grid2 item xs={12} sm={6} md={4}>
            <Card>
              <CardContent>
                <Typography variant="h5" component="div">Define Departments</Typography>
                <Typography variant="body2">Easily set up and manage various departments within your organization.</Typography>
              </CardContent>
            </Card>
          </Grid2>
          <Grid2 item xs={12} sm={6} md={4}>
            <Card>
              <CardContent>
                <Typography variant="h5" component="div">Import Employee Data</Typography>
                <Typography variant="body2">Seamlessly import employee information for quick setup.</Typography>
              </CardContent>
            </Card>
          </Grid2>
          <Grid2 item xs={12} sm={6} md={4}>
            <Card>
              <CardContent>
                <Typography variant="h5" component="div">Setup Payroll</Typography>
                <Typography variant="body2">Configure payroll with tax limitations for accurate calculations.</Typography>
              </CardContent>
            </Card>
          </Grid2>
          <Grid2 item xs={12} sm={6} md={4}>
            <Card>
              <CardContent>
                <Typography variant="h5" component="div">Manage Allowances</Typography>
                <Typography variant="body2">Track and manage employee allowances effectively.</Typography>
              </CardContent>
            </Card>
          </Grid2>
          <Grid2 item xs={12} sm={6} md={4}>
            <Card>
              <CardContent>
                <Typography variant="h5" component="div">Generate Reports</Typography>
                <Typography variant="body2">Generate detailed payroll reports for better insights.</Typography>
              </CardContent>
            </Card>
          </Grid2>
          <Grid2 item xs={12} sm={6} md={4}>
            <Card>
              <CardContent>
                <Typography variant="h5" component="div">PDF Pay Slips</Typography>
                <Typography variant="body2">Generate and download PDF pay slips for employees.</Typography>
              </CardContent>
            </Card>
          </Grid2>
        </Grid2>
      </Box>
    </>
  );
};

export default Homepage;
