import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { TextField } from '@mui/material';
const style = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 500,
    height: 230,
    bgcolor: 'background.paper',
    boxShadow: 24,
    p: 4,
  };

const SearchEmployeeModal = ({open, handleClose}) => {
 
  return (
    <div>
    <Modal
      open={open}
      onClose={handleClose}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"
    >
      <Box sx={style}>
        <div>
        <div>
        <Typography id="modal-modal-title" variant="h6" component="h2" className='font-bold'>
          Enter Department Name
        </Typography>
        </div>
        <div className='mt-8'>
        <TextField
          className='outline-none'
          label="Department Name"
          variant="outlined"
          size='small'
          fullWidth
          />
        </div>
         
         <div className='flex justify-end mt-6 space-x-8'>
         <Button
              variant="contained"
              color="primary"
              size='medium'
            >
              Search
            </Button>
            <Button
              variant="contained"
              color="secondary"
              size='medium'
              onClick={handleClose}
            >
              Cancel
            </Button>
         </div>
         </div>
        
      </Box>
    </Modal>
  </div>
  )
}

export default SearchEmployeeModal