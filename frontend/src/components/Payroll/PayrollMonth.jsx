import {
  Button,
  Divider,
  Grid2,
  InputAdornment,
  TextField,
  Typography,
  IconButton,
} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const PayrollMonth = () => {
  const navigate = useNavigate();
  const [searchValue, setSearchValue] = useState("");

  const handleAddPayrollMonth = () => {
    navigate("/addPayrollMonth");
  };

  const handleSearchPayrollMonth = () => {
    // Logic for searching employees
  };

  return (
    <>
      <div className="flex flex-col p-4 space-y-6">
        <Typography variant="h4" className="text-3xl font-bold mb-4">
          Payroll Month Dashboard
        </Typography>
        <Divider sx={{ height: 4, bgcolor: "gray" }} />
      </div>
      <div>
        <Grid2 className="ml-4" container spacing={2} alignItems="flex-end">
          <Grid2
            container
            spacing={2}
            alignItems="flex-start"
            sx={{ marginTop: 2 }}
          >
            <Grid2 item xs={6}>
              <TextField
                label="Payroll Month Name"
                variant="outlined"
                size="small"
                fullWidth
              />
            </Grid2>

            <Grid2 item xs={6}>
              <TextField
                label="Payroll Year"
                variant="outlined"
                size="small"
                fullWidth
              />
            </Grid2>
          </Grid2>

          <Grid2 item xs={2}>
            <Button variant="contained" color="primary" fullWidth>
              Show
            </Button>
          </Grid2>
          <Grid2 item xs={2}>
            <Button variant="contained" color="secondary" fullWidth>
              Add New
            </Button>
          </Grid2>
        </Grid2>
      </div>
    </>
  );
};

export default PayrollMonth;
