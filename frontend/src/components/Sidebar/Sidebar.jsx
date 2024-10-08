import React, { useState } from "react";
import { List, ListItem, ListItemIcon, ListItemText, Collapse } from "@mui/material";
import MonetizationOnIcon from "@mui/icons-material/MonetizationOn";
import PeopleIcon from "@mui/icons-material/People";
import ApartmentIcon from "@mui/icons-material/Apartment";
import ReceiptIcon from "@mui/icons-material/Receipt";
import RemoveCircleOutlineIcon from "@mui/icons-material/RemoveCircleOutline";
import ExpandLess from "@mui/icons-material/ExpandLess";
import ExpandMore from "@mui/icons-material/ExpandMore";
import DescriptionIcon from "@mui/icons-material/Description"; // For Reports
import { useNavigate } from "react-router-dom";

const Sidebar = () => {

  const navigate = useNavigate();

  const [openGeneralSetup, setOpenGeneralSetup] = useState(false);
  const [openEmployeeMgmt, setOpenEmployeeMgmt] = useState(false);
  const [openPayroll, setOpenPayroll] = useState(false);

  const toggleGeneralSetup = () => setOpenGeneralSetup(!openGeneralSetup);
  const toggleEmployeeMgmt = () => setOpenEmployeeMgmt(!openEmployeeMgmt);
  const togglePayroll = () => setOpenPayroll(!openPayroll);

  const handleDepartment = () => {
    navigate("/department")
  }

  const handleEmployees = () => {
    navigate("/employee")
  }

  const handleAddEmployee = () => {
    navigate('/addEmployee')
  }

  const handlePayrollMonth = () => {
    navigate('/payrollMonth')
  }

  return (
    <div className="w-80 bg-blue-700 min-h-screen text-white font-bold">
      <h2 className="text-2xl font-bold text-center py-6">
        Payroll Management System
      </h2>
      <div>
        <h2 className="text-3xl font-semibold text-gray-100 px-8 py-4">
          Dashboard
        </h2>
      </div>
      <List>
        <ListItem button onClick={toggleGeneralSetup} className="hover:bg-blue-600">
          <ListItemIcon>
            <ApartmentIcon className="text-white" />
          </ListItemIcon>
          <ListItemText primary="General Setup" className="text-2xl cursor-pointer" />
          {openGeneralSetup ? <ExpandLess /> : <ExpandMore />}
        </ListItem>
        <Collapse in={openGeneralSetup} timeout="auto" unmountOnExit>
          <List component="div" disablePadding>
            <ListItem button className="ml-6 hover:bg-blue-600">
              <ListItemIcon>
                <ApartmentIcon className="text-white" />
              </ListItemIcon>
              <ListItemText primary="Department" className="text-2xl cursor-pointer" onClick={handleDepartment} />
            </ListItem>
          </List>
        </Collapse>

        <ListItem button onClick={toggleEmployeeMgmt} className="hover:bg-blue-600">
          <ListItemIcon>
            <PeopleIcon className="text-white" />
          </ListItemIcon>
          <ListItemText primary="Employee Management" className="text-2xl cursor-pointer" />
          {openEmployeeMgmt ? <ExpandLess /> : <ExpandMore />}
        </ListItem>
        <Collapse in={openEmployeeMgmt} timeout="auto" unmountOnExit>
          <List component="div" disablePadding>
            <ListItem button className="ml-6 hover:bg-blue-600">
              <ListItemIcon>
                <PeopleIcon className="text-white" />
              </ListItemIcon>
              <ListItemText primary="Employees" className="text-2xl cursor-pointer"  onClick={handleEmployees}/>
            </ListItem>
            <ListItem button className="ml-6 hover:bg-blue-600">
              <ListItemIcon>
                <PeopleIcon className="text-white" />
              </ListItemIcon>
              <ListItemText primary="Add Employee" className="text-2xl cursor-pointer"  onClick={handleAddEmployee}/>
            </ListItem>
          </List>
        </Collapse>

        <ListItem button onClick={togglePayroll} className="hover:bg-blue-600">
          <ListItemIcon>
            <MonetizationOnIcon className="text-white" />
          </ListItemIcon>
          <ListItemText primary="Payroll" className="text-2xl cursor-pointer" />
          {openPayroll ? <ExpandLess /> : <ExpandMore />}
        </ListItem>
        <Collapse in={openPayroll} timeout="auto" unmountOnExit>
          <List component="div" disablePadding>
            <ListItem button className="ml-6 hover:bg-blue-600">
              <ListItemIcon>
                <DescriptionIcon className="text-white" />
              </ListItemIcon>
              <ListItemText primary="Payroll Month" className="text-2xl cursor-pointer" onClick={handlePayrollMonth} />
            </ListItem>
            <ListItem button className="ml-6 hover:bg-blue-600">
              <ListItemIcon>
                <DescriptionIcon className="text-white" />
              </ListItemIcon>
              <ListItemText primary="Payroll Setup" className="text-2xl cursor-pointer" />
            </ListItem>
            <ListItem button className="ml-6 hover:bg-blue-600">
              <ListItemIcon>
                <DescriptionIcon className="text-white" />
              </ListItemIcon>
              <ListItemText primary="Tax Slabs" className="text-2xl cursor-pointer" />
            </ListItem>
          </List>
        </Collapse>

        <ListItem button className="hover:bg-blue-600">
          <ListItemIcon>
            <DescriptionIcon className="text-white" />
          </ListItemIcon>
          <ListItemText primary="Reports" className="text-2xl cursor-pointer" />
        </ListItem>
      </List>
    </div>
  );
};

export default Sidebar;
