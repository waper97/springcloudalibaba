import axios from 'axios'
export const listUser = (params) => {
    return axios.get('/api/job-hunting/jobHunting/listJobHunting', params);
}