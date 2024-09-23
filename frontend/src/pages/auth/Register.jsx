import React from 'react';
import { useFormik } from 'formik';
import { TextField, Button, Link, Typography } from '@mui/material';
import * as Yup from 'yup';

const RegisterForm = () => {
  const formik = useFormik({
    initialValues: {
      email: '',
      password: '',
    },
    validationSchema: Yup.object({
      email: Yup.string().email('Invalid email address').required('Required'),
      password: Yup.string().min(6, 'Password must be at least 6 characters').required('Required'),
    }),
    onSubmit: (values) => {
      console.log('Form data', values);
    },
  });

  return (
    <div className="min-h-screen flex items-center justify-center ">
      <div className="w-full max-w-sm p-8 rounded-md shadow-lg space-y-5 bg-slate-200">
        <Typography variant="h3" className="text-left">
          Sign up
        </Typography>

        <form onSubmit={formik.handleSubmit} className='space-y-4'>
        <div className='space-y-5'>
          <TextField
            label="First Name"
            variant="outlined"
            fullWidth
            inputLabel={{ style: { color: '#A0AEC0' } }}
            input={{ style: { color: 'white' } }}
            className="mb-6" 
            type="text"
            id="firstName"
            name="firstName"
            value={formik.values.email}
          />
          </div>
          <div className='space-y-5'>
          <TextField
            label="Last Name"
            variant="outlined"
            fullWidth
            inputLabel={{ style: { color: '#A0AEC0' } }}
            input={{ style: { color: 'white' } }}
            className="mb-6" 
            type="text"
            id="lastName"
            name="lastName"
            value={formik.values.email}
          />
          </div>
          <div className='space-y-5'>
          <TextField
            label="Email"
            variant="outlined"
            fullWidth
            inputLabel={{ style: { color: '#A0AEC0' } }}
            input={{ style: { color: 'white' } }}
            className="mb-6" 
            type="email"
            id="email"
            name="email"
            value={formik.values.email}
          />
          </div>

          <div className='space-y-5'>
          <TextField
            label="Password"
            variant="outlined"
            fullWidth
            sx={{borderRadius: '8px'}}
            inputLabel={{ style: { color: '#A0AEC0' } }}
            input={{ style: { color: '#2D3748' } }}
            className="mb-6 rounded-md" 
            type="password"
            id="password"
            name="password"
            value={formik.values.password}
          />
          </div>

          <Button
            type="submit"
            variant="contained"
            color="primary"
            fullWidth
            className="mb-6 bg-blue-600 hover:bg-blue-700 " 
          >
            Sign up
          </Button>
        </form>

        <Typography variant="body2" className="text-center text-gray-400">
          Already have an account?{' '}
          <Link href="#" className="text-blue-500">
            Sign in
          </Link>
        </Typography>
      </div>
    </div>
  );
};

export default RegisterForm;
