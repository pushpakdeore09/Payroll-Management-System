import React, { useState } from "react";
import {
  Typography,
  Divider,
  TextField,
  Button,
} from "@mui/material";
import { useNavigate } from "react-router-dom";

const PayrollMonth = () => {

  const navigate = useNavigate();
  const [searchValues, setSearchValues] = useState({
    searchMonth: "",
    searchYear: "",
  });
  
  const handleAddPayrollMonth = () => {
    navigate('/addPayrollMonth')
  }

  const handleSearch = (searchValues) => {
  };

  return (
    <div className="flex flex-col p-4 space-y-6">
      <Typography variant="h4" className="text-3xl font-bold mb-4">
        Payroll Month
      </Typography>
      <Divider sx={{ height: 4, bgcolor: "gray" }} />

      <div className="flex justify-between mt-4">
        <Button variant="contained" color="secondary" onClick={handleAddPayrollMonth}>
          Add Payroll Month
        </Button>
      </div>
      <div className="grid grid-cols-3 gap-6 mt-4">
        <TextField
          fullWidth
          label="Payroll Month"
          size="small"
          value={searchValues.searchMonth}
          onChange={(e) => setSearchValues({ ...searchValues, searchMonth: e.target.value })}
          variant="outlined"
        />
        <TextField
          fullWidth
          label="Year"
          size="small"
          value={searchValues.searchYear}
          onChange={(e) => setSearchValues({ ...searchValues, searchYear: e.target.value })}
          type="number"
          variant="outlined"
        />
        <Button sx={{width: 100}} variant="contained" color="primary" onClick={handleSearch}>
          Search
        </Button>
      </div>
      
    </div>
  );
};

export default PayrollMonth;
