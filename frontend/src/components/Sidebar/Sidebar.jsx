import React from "react";
import { List, ListItem, ListItemIcon, ListItemText } from "@mui/material";
import MonetizationOnIcon from "@mui/icons-material/MonetizationOn";
import PeopleIcon from "@mui/icons-material/People";
import ApartmentIcon from "@mui/icons-material/Apartment";
import ReceiptIcon from "@mui/icons-material/Receipt";
import RemoveCircleOutlineIcon from "@mui/icons-material/RemoveCircleOutline";

const Sidebar = () => {
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
        <ListItem button>
          <ListItemIcon>
            <ApartmentIcon style={{ color: "white" }} />
          </ListItemIcon>
          <ListItemText
            primary="Department"
            sx={{ fontSize: "24px", fontWeight: "bold", color: "white" }}
          />
        </ListItem>
        <ListItem button>
          <ListItemIcon>
            <PeopleIcon style={{ color: "white" }} />
          </ListItemIcon>
          <ListItemText
            primary="Employees"
            sx={{ fontSize: "24px", fontWeight: "bold" }}
          />
        </ListItem>
        <ListItem button>
          <ListItemIcon>
            <MonetizationOnIcon style={{ color: "white" }} />
          </ListItemIcon>
          <ListItemText
            primary="Allowances "
            sx={{ fontSize: "24px", fontWeight: "bold" }}
          />
        </ListItem>
        <ListItem button>
          <ListItemIcon>
            <RemoveCircleOutlineIcon style={{ color: "white" }} />
          </ListItemIcon>
          <ListItemText
            primary="Deductions"
            sx={{ fontSize: "24px", fontWeight: "bold" }}
          />
        </ListItem>
        <ListItem button>
          <ListItemIcon>
            <ReceiptIcon style={{ color: "white" }} />
          </ListItemIcon>
          <ListItemText
            primary="Payroll"
            sx={{ fontSize: "24px", fontWeight: "bold" }}
          />
        </ListItem>
      </List>
    </div>
  );
};

export default Sidebar;
