import api from '..';

export async function _getHistory() {
    return api({
        method: 'GET', url: '/history/getAll',
    });
}
