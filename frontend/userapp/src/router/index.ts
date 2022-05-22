import * as VueRouter from 'vue-router';
import auth from '../views/Auth.vue';
import index from '../views/Index.vue';
import Presentation from '../components/modules/presentation/Presentation.vue';
import EduBookMall from '../components/modules/mall/EduBookMall.vue';
import AcdmWorksMall from '../components/modules/mall/AcademicWorksMall.vue';
import SocialReadingMall from '../components/modules/mall/SocialReadingMall.vue';
import JournalMall from '../components/modules/mall/JournalMall.vue';
import Product from '../components/modules/mall/Product.vue';
import Settlement from '../components/modules/mall/Settlement.vue';
import SearchProducts from '../components/modules/mall/SearchProductsList.vue';


import PaymentResult from '../components/modules/mall/PaymentResult.vue';
import PersonalCenter from '../components/modules/user/PersonalCenter.vue';
import Supports from '../components/modules/supports/Supports.vue';

const routes = [
  {
    path: '/',
    redirect: '/presentation',
    component: index,
    children: [
      {
        path: 'presentation',
        component: Presentation,
      },
      {
        path: 'edumall',
        component: EduBookMall,
      },
      {
        path: 'academicmall',
        component: AcdmWorksMall,
      },
      {
        path: 'socialmall',
        component: SocialReadingMall,
      },
      {
        path: 'journalmall',
        component: JournalMall,
      },
      {
        path: 'searchProducts',
        component: SearchProducts,
      },
      {
        path: 'product/:id',
        component: Product,
      },

      {
        path: 'settlement',
        component: Settlement,
      },
      {
        path: 'payment-result',
        component: PaymentResult,
      },
      {
        path: 'supports',
        component: Supports,
      },
      {
        path: 'user',
        component: PersonalCenter,
      },
      {
        path: 'login',
        component: auth,
      },
    ],
  },
];

const router = VueRouter.createRouter({
  //  hash 模式。
  history: VueRouter.createWebHashHistory(),
  routes, // `routes: routes` 的缩写
});

export default router;
