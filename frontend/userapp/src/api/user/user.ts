import api from '..';

// 用户信息
interface IUserInfo {
  email: string,
  consignee: string,
  phone_num: string,
  address: string,
}

// 获取用户信息
export async function _getUserInfo() {
  return api({ method: 'GET', url: '/info/getInfoByID' });
}

// 获取用户积分
export async function _getUserPoints() {
  return api({ method: 'GET', url: '/info/getPointsByID' });
}

// 更新用户信息
export async function _updateUserInfo(userInfoDto: IUserInfo) {
  return api({ method: 'POST', url: '/info/updateInfoByID', data: userInfoDto });
}

// 获取用户申请历史
export async function _getUserHistory() {
  return api({ method: 'GET', url: '/history/getHistory' });
}
