import { Button, Divider, InputAdornment, TextField, Typography } from '@mui/material';
import SearchIcon from "@mui/icons-material/Search";
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const PayrollMonth = () => {
  const navigate = useNavigate();
  const [searchValue, setSearchValue] = useState("");

  const handleAddPayrollMonth = () => {
    navigate('/addPayrollMonth')
  };

  const handleSearchPayrollMonth = () => {
    // Logic for searching employees
  };

  return (
    <>
    <div className="flex flex-col p-4">
      <div className="flex flex-col space-y-6">
        <Typography variant="h4" className="text-3xl font-bold mb-4">
          Payroll Month
        </Typography>
        <Divider sx={{ height: 4, bgcolor: "gray" }} />
      </div>

      <div className="flex justify-between items-center">
        <Button
          variant="contained"
          color="primary"
          fullWidth
          size="medium"
          sx={{ width: "210px", marginBottom: "16px", marginTop: "25px" }}
          onClick={handleAddPayrollMonth}
        >
          + Add Payroll Month
        </Button>

        <div style={{ position: "relative", width: "300px" }}>
          <TextField
            label="Search Payroll Month"
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
                    onClick={handleSearchPayrollMonth}
                  />
                </InputAdornment>
              ),
            }}
          />
        </div>
        
      </div>
    </div> 
    </>
  );
};

export default PayrollMonth;
