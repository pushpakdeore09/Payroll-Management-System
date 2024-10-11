import { Button, Divider, Grid2, TextField, Typography } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";

const Payroll = () => {

  const navigate = useNavigate();

  const handleAddPayroll = () => {
    navigate('/addPayroll')
  }
  return (
    <>
      <div className="flex flex-col p-4 space-y-6">
        <Typography variant="h4" className="text-3xl font-bold mb-4">
          Payroll Dashboard
        </Typography>
        <Divider sx={{ height: 4, bgcolor: "gray" }} />
      </div>
      <div>
        <Grid2 className="ml-4" container spacing={2} alignItems="flex-end">
          <Grid2 item xs={10} size={8}>
            <TextField
              readOnly
              label="Payroll Name"
              variant="outlined"
              size="small"
              fullWidth
            />
          </Grid2>

          <Grid2 item xs={2}>
            <Button variant="contained" color="primary" fullWidth>
              Show
            </Button>
          </Grid2>
          <Grid2 item xs={2}>
            <Button variant="contained" color="secondary" fullWidth onClick={handleAddPayroll}>
              Add New
            </Button>
          </Grid2>
        </Grid2>
      </div>
    </>
  );
};

export default Payroll;
