import api from '..';

export async function _getUser() {
    return api({
        method: 'GET', url: '/admin/userPermission',
    });
}
