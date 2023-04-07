import axios from 'axios'
axios.defaults.baseURL = '/api'
export const listJob = (params) => {
   return axios.get('/job-hunting/jobHunting/listJobHunting', params);
}

export const login = (params) => {
   return axios.post('/auth-service/auth/login',{ params});
}

export const listHero = (params) => {
   return axios.get('/job-hunting/jobHunting/listHero', params);
}

export const listItem = (params) => {
   return axios.get('/job-hunting/jobHunting/listItem', params);
}
export const listSummoner = (params) => {
   return axios.get('/job-hunting/jobHunting/listSummoner', params);
}