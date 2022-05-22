import api from '..';

export async function _getProducts(params) {
    return api({
        method: 'GET', url: '/products/list',
        params: params
    });
}

interface IEditProduct {
    bookId: 1,
    title: string;
    author: string;
    grade1: string;
    grade2: string;
    grade3: string;
    type: string;
    imgsrc: string;
    isbn: string;
    issn: string;
    publicationTime: string;
    wordCount: string;
    format: string;
    pageCount: string;
    bookbinding: string;
    language: string;
    points: number;
    delflag: CharacterData;
}

interface id{
    id:number
}

export async function _editProducts(editProduct: IEditProduct) {
    return api({ method: 'POST', url: '/admin/edit', data: editProduct });
}

export async function _deleteProducts(id:id) {
    return api({ method: 'POST', url: '/admin/delete', data: id });
}