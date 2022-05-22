import * as VueRouter from 'vue-router';
import index from '../components/Index.vue';
import productList from '../model/productsManager/ProductsList.vue';
import addProduct from '../model/productsManager/AddProduct.vue';
import history from '../model/historyManager/HistoryList.vue';
import user from '../model/userManager/UserList.vue';
import certify from '../model/certifyManager/Certify.vue';
import review from '../model/reviewManager/Review.vue';
import time from '../model/main/Time.vue';

const routes = [
    {
        path: '/',
        redirect: '/list',
        component: index,
        children: [
            {
                path: 'list',
                component: productList,
            },
            {
                path: 'time',
                component:time,
            },
            {
                path: 'addProduct',
                component: addProduct,
            },
            {
                path: 'history',
                component: history,
            },
            {
                path: 'user',
                component: user,
            },
            {
                path: 'certify',
                component: certify,
            },
            {
                path: 'review',
                component: review,
            }
        ]
    },
];

const router = VueRouter.createRouter({
    //  hash 模式。
    history: VueRouter.createWebHashHistory(),
    routes, // `routes: routes` 的缩写
});

export default router;