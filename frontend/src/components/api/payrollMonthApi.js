import apiClient from "./apiClient";

export const addPayrollMonth = async (payrollMonthData) => {
  try {
    const response = await apiClient.post("/addPayrollMonth", payrollMonthData);
    return response;
  } catch (error) {
    throw error;
  }
};

export const getPayrollMonth =  async (searchValues) => {
  console.log(searchValues);
  try {
    const { monthName, year } = searchValues;
    const response = await apiClient.get(`/payrollMonth/${monthName}/${year}`);
    
    console.log(response);
    
    return response;
  } catch (error) {
    throw error;
  }
}
