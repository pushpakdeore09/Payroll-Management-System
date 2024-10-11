import apiClient from "./apiClient";

export const addPayroll = async (payrollData) => {
    try {
        const response = await apiClient.post("/addPayroll", payrollData);
        return response;
    } catch (error) {
        throw error;
    }
}